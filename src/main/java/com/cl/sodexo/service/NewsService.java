package com.cl.sodexo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cl.sodexo.dto.Event;
import com.cl.sodexo.dto.Launch;
import com.cl.sodexo.dto.ResponseArticles;
import com.cl.sodexo.dto.Result;
import com.cl.sodexo.model.Favorite;
import com.cl.sodexo.repository.NewsRepository;
import com.cl.sodexo.util.Utils;

/**
 * The Class NewsService.
 */
@Component
public class NewsService {

	private static final String URL_SERVICE = "https://api.spaceflightnewsapi.net/v4/articles/";

	@Autowired
	private NewsRepository newsRepository;

	public Favorite createFavorite(Favorite favorite) {
		return newsRepository.save(favorite);
	}

	public List<Long> getAllFavoritesById(Long idUser) {
		return newsRepository.getAllFavoritesById(idUser);

	}

	public Favorite getFavoriteById(Long id) {
		Optional<Favorite> optionalFavorite = newsRepository.findById(id);
		return optionalFavorite.get();
	}

	public void deleteFavorite(Long idUser, Long idNews) {
		newsRepository.deleteByFavorite(idUser, idNews);

	}

	public boolean getNewsByUser(Long idUser, Long idNews) {
		return newsRepository.findByFavorite(idUser, idNews);

	}
	
	public boolean findByUserId(Long idUser) {
		return newsRepository.findByUserId(idUser);

	}

	public String getClientRest(String in) {

		String output = null;

		try {

			URL url = new URL(URL_SERVICE + in);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			output = br.readLine();
			conn.disconnect();

		} catch (MalformedURLException e) {

		} catch (IOException e) {

		}

		return output;
	}

	public ResponseArticles jsonOutputByFilter(final String in) {

		JSONObject jsonIn = new JSONObject(in);
		ResponseArticles resp = new ResponseArticles();
		Launch launch = null;
		Event event = null;
		Result result = null;

		resp.setCount(jsonIn.getInt("count"));
		resp.setNext(jsonIn.getString("next"));
		resp.setPrevious(jsonIn.getString("previous"));

		List<Result> results = new ArrayList<Result>();
		List<Launch> launchs = null;
		List<Event> events = null;

		JSONArray array = jsonIn.getJSONArray("results");
		for (int i = 0; i < array.length(); i++) {

			launchs = new ArrayList<Launch>();
			events = new ArrayList<Event>();

			result = new Result();

			result.setId(array.getJSONObject(i).getInt("id"));
			result.setTitle(array.getJSONObject(i).getString("title"));
			result.setUrl(array.getJSONObject(i).getString("url"));
			result.setImage_url(array.getJSONObject(i).getString("image_url"));
			result.setNews_site(array.getJSONObject(i).getString("news_site"));
			result.setSummary(array.getJSONObject(i).getString("summary"));
			result.setPublished_at(Utils.timestampToDate(array.getJSONObject(i).getString("published_at")));
			result.setUpdated_at(Utils.timestampToDate(array.getJSONObject(i).getString("updated_at")));
			result.setFeatured(array.getJSONObject(i).getBoolean("featured"));

			JSONArray array2 = array.getJSONObject(i).getJSONArray("launches");
			for (int k = 0; k < array2.length(); k++) {

				launch = new Launch();

				launch.setLaunch_id(array2.getJSONObject(k).getString("launch_id"));
				launch.setProvider(array2.getJSONObject(k).getString("provider"));
				launchs.add(launch);

			}

			JSONArray array3 = array.getJSONObject(i).getJSONArray("events");
			for (int j = 0; j < array3.length(); j++) {

				event = new Event();

				event.setEvent_id(array3.getJSONObject(j).getInt("event_id"));
				event.setProvider(array3.getJSONObject(j).getString("provider"));
				events.add(event);

			}

			result.setLaunches(launchs);
			result.setEvents(events);
			results.add(result);
		}

		resp.setResults(results);

		return resp;

	}

	public Result jsonOutputById(String in) {

		JSONObject jsonIn = new JSONObject(in);

		Launch launch = null;
		Event event = null;
		Result result = null;

		List<Launch> launchs = null;
		List<Event> events = null;

		launchs = new ArrayList<Launch>();
		events = new ArrayList<Event>();

		result = new Result();

		result.setId(jsonIn.getInt("id"));
		result.setTitle(jsonIn.getString("title"));
		result.setUrl(jsonIn.getString("url"));
		result.setImage_url(jsonIn.getString("image_url"));
		result.setNews_site(jsonIn.getString("news_site"));
		result.setSummary(jsonIn.getString("summary"));
		result.setPublished_at(Utils.timestampToDate(jsonIn.getString("published_at")));
		result.setUpdated_at(Utils.timestampToDate(jsonIn.getString("updated_at")));
		result.setFeatured(jsonIn.getBoolean("featured"));

		JSONArray array2 = jsonIn.getJSONArray("launches");
		for (int k = 0; k < array2.length(); k++) {

			launch = new Launch();

			launch.setLaunch_id(array2.getJSONObject(k).getString("launch_id"));
			launch.setProvider(array2.getJSONObject(k).getString("provider"));
			launchs.add(launch);

		}

		JSONArray array3 = jsonIn.getJSONArray("events");
		for (int j = 0; j < array3.length(); j++) {

			event = new Event();

			event.setEvent_id(array3.getJSONObject(j).getInt("event_id"));
			event.setProvider(array3.getJSONObject(j).getString("provider"));
			events.add(event);

		}

		result.setLaunches(launchs);
		result.setEvents(events);

		return result;
	}
}
