package com.cl.sodexo.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cl.sodexo.dto.ResponseUser;
import com.cl.sodexo.model.User;
import com.cl.sodexo.service.UserService;
import com.cl.sodexo.util.Utils;

/**
 * The Class ProductoController.
 */
@RestController
@RequestMapping(value = "/news/user")
public class UserController {

	/** The log. */
	private Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseUser createUser(@Valid @RequestBody User user) {
		LOG.info("se ejecuta createUser()");

		ResponseUser resp = new ResponseUser();

		try {

			boolean validaMail = Utils.validaEmail(user.getEmail());

			if (!validaMail) {
				LOG.error("El formato de correo no es valido");
				resp.setMessage("El formato de correo no es valido " + user.getEmail());
				return resp;
			}

			boolean existMail = userService.getUserByEmail(user.getEmail());

			if (existMail) {
				LOG.error("El correo ya registrado");
				resp.setMessage("El correo ya registrado");
				return resp;
			}

			user.setCreated(Utils.dateFormat());

			User out = userService.createuser(user);

			resp.setUuid(out.getUuid().intValue());
			resp.setEmail(out.getEmail());
			resp.setMessage("user creado OK");

			return resp;

		} catch (Exception e) {
			LOG.error("Error crear user");
			resp.setMessage("Error crear user");

			return resp;

		}

	}
}
