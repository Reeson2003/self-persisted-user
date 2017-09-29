package ru.reeson2003.user.rest.client.service;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ru.reeson2003.user.api.User;
import ru.reeson2003.user.rest.client.stub.UserStub;

import java.util.List;

/**
 * Created by Pavel Gavrilov on 29.09.2017.
 */
public class RestClientService {
    private String domain;
    private RestTemplate restTemplate = new RestTemplate();

    public RestClientService(String domain) {
        this.domain = domain;
    }

    public User getByLogin(String login) {
        String url = domain + "/user?login=" + login;
        return restTemplate.getForObject(url , UserStub.class);
    }

    public List<User> getAll() {
        String url = domain + "/users";
        return restTemplate.getForObject(url , List.class);
    }

    public boolean addUser(String login, String password) {
        String url = domain+"/user";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("login", login);
        map.add("password", password);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        return restTemplate.postForObject(url , request , Boolean.class );
    }

    public boolean updateUser(User user) {
        String url = domain + "/user";
        HttpEntity<User> entity = new HttpEntity<>(user);
        return  restTemplate.exchange(url, HttpMethod.PUT, entity, Boolean.class).getBody();
    }

    public boolean deleteUser(String login) {
        String url = domain + "/user?login=" + login;
        HttpEntity<Boolean> entity = new HttpEntity<>(false);
        return restTemplate.exchange(url, HttpMethod.DELETE, entity, Boolean.class).getBody();
    }

    public String getDomain() {
        return domain;
    }
}
