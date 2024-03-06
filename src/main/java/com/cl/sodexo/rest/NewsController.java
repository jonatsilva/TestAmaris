package com.cl.sodexo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cl.sodexo.dto.RequestArticles;
import com.cl.sodexo.dto.ResponseArticles;
import com.cl.sodexo.dto.ResponseFavorite;
import com.cl.sodexo.dto.Result;
import com.cl.sodexo.model.Favorite;
import com.cl.sodexo.service.NewsService;
import com.cl.sodexo.util.Utils;

@RestController
@RequestMapping(value = "/news/articles")
public class NewsController {

	/** The log. */
	private Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private NewsService newsService;

	@GetMapping
	public ResponseArticles searchNews(RequestArticles articles) {
		LOG.info("se ejecuta searchNews()");

		ResponseArticles resp = null;
		Integer limit = articles.getLimit() == null ? 10 : articles.getLimit();
		Integer offset = articles.getOffset() == null ? 10 : articles.getOffset();
		String ordering = articles.getOrdering() == null ? "" : articles.getOrdering();
		String search = articles.getSearch() == null ? "" : articles.getSearch();

		try {

			String filter = "?" + "limit=" + limit + "&" + "offset=" + offset + "&" + "ordering=" + ordering + "&"
					+ "search=" + search;

			String out = newsService.getClientRest(filter);
			resp = newsService.jsonOutputByFilter(out);

		} catch (Exception e) {
			LOG.error("Error conulta a servicio REST ", e.getCause());
		}

		return resp;

	}

	@PostMapping
	public ResponseFavorite createFavorite(@Valid @RequestBody Favorite favorite) {
		LOG.info("se ejecuta createFavorite()");

		ResponseFavorite resp = new ResponseFavorite();

		try {

			// validamo que el IdUser exista creado
			boolean existsUser = newsService.findByUserId(favorite.getIdUser());

			if (!existsUser) {
				LOG.error("El usuario no existe registrado");
				resp.setMessage("El usuario no existe registrado");
				return resp;
			}

			// validamos si el id favorito ya existe registrado para el usuario.
			boolean existsNews = newsService.getNewsByUser(favorite.getIdUser(), favorite.getIdNews());

			if (existsNews) {
				LOG.error("El IdNews ya esta registrado para el usuario");
				resp.setMessage("El IdNews ya esta registrado para el usuario");
				return resp;
			}

			favorite.setCreated(Utils.dateFormat());

			Favorite out = newsService.createFavorite(favorite);
			resp.setUuid(out.getUuid());
			resp.setIdUser(out.getIdUser());
			resp.setIdNews(out.getIdNews());
			resp.setCreated(out.getCreated());
			resp.setMessage("favorite registrado OK");

			return resp;

		} catch (Exception e) {
			LOG.error("Error crear favorite ", e.getCause());
			resp.setMessage("Error crear favorite" + e.getCause());

			return resp;
		}

	}

	@GetMapping("{idUser}")
	public List<Result> getAllFavoritesById(@PathVariable(value = "idUser", required = true) Long idUser) {
		LOG.info("se ejecuta getAllFavoritesById()");

		List<Result> results = new ArrayList<Result>();

		try {

			List<Long> value = newsService.getAllFavoritesById(idUser);

			for (Long idNews : value) {

				String filter = idNews + "/";
				String out = newsService.getClientRest(filter);
				Result result = newsService.jsonOutputById(out);
				results.add(result);
			}

		} catch (Exception e) {
			LOG.error("Error buscar All favorites ", e.getCause());

		}

		return results;
	}

	@DeleteMapping("{idUser} {idNews}")
	public String deleteFavorite(@PathVariable(value = "idUser", required = true) Long idUser,
			@PathVariable(value = "idNews", required = true) Long idNews) {
		LOG.info("se ejecuta deleteFavorite()");

		try {

			newsService.deleteFavorite(idUser, idNews);

		} catch (Exception e) {
			LOG.error("Error delete favorite ", e.getCause());
			return "Error delete favorite " + e.getCause() + " idUser " + idUser + " idNews " + idNews;
		}

		return "OK delete favorite" + " idUser " + idUser + " idNews " + idNews;

	}

}
