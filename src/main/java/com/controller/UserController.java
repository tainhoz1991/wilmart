package com.controller;

import com.dto.SearchDTO;
import com.dto.UserBaseDTO;
import com.dto.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
@EnableWebMvc
//@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ModelAndView getUsers(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("fullName", "Nguyen Ngoc Tai");
        return mav;
    }

    @GetMapping("/users")
    public ModelAndView getAllUsers() throws ExecutionException, InterruptedException, IOException {
        ModelAndView mav = new ModelAndView("management_user");
//        UserDTO userDTO = new UserDTO();
//        userDTO.setFullName("abc");
//        userDTO.setDepartment("dev");
//        userDTO.setGender("male");
//        userDTO.setEmail("abc");
//        userDTO.setId(1);
//        userDTO.setMobilePhone("0000000");
//        List<UserDTO> test = new ArrayList<>();
//        test.add(userDTO);
        List<UserDTO> userDTOList = service.getAllUsers();
        mav.addObject("users", userDTOList);


        return mav;
    }

    @PostMapping("/users/create")
    public ModelAndView create(UserBaseDTO dto) throws ExecutionException, InterruptedException, JsonProcessingException {
        ModelAndView mav = new ModelAndView("management_user");
        List<UserDTO> userDTOList = service.create(dto);
        mav.addObject("users", userDTOList);
        return mav;
    }

    @GetMapping("/users/create")
    public ModelAndView createView(){
        ModelAndView mav = new ModelAndView("create_user");
        return mav;
    }

    @GetMapping("/users/update/{userId}")
    public ModelAndView updateView(@PathVariable(name = "userId") String userId) throws ExecutionException, JsonProcessingException, InterruptedException {
        ModelAndView mav = new ModelAndView("update_user");
        UserDTO userDTO = service.findUserById(userId);
        mav.addObject("user", userDTO);
        return mav;
    }

    @GetMapping("/users/info/{userId}")
    public ModelAndView infoUserView(@PathVariable(name = "userId") String userId) throws ExecutionException, JsonProcessingException, InterruptedException {
        ModelAndView mav = new ModelAndView("info_user");
        UserDTO userDTO = service.findUserById(userId);
        mav.addObject("user", userDTO);
        return mav;
    }


    @PostMapping("/users/update")
    public ModelAndView update(UserDTO dto) throws ExecutionException, InterruptedException, JsonProcessingException {
        ModelAndView mav = new ModelAndView("management_user");
        List<UserDTO> userDTOList = service.update(dto);
        mav.addObject("users", userDTOList);
        return mav;
    }

    @GetMapping("/users/delete/{userId}")
    public ModelAndView delete(@PathVariable(name = "userId") String userId) throws ExecutionException, InterruptedException, JsonProcessingException {
        ModelAndView mav = new ModelAndView("management_user");
        List<UserDTO> userDTOList = service.delete(userId);
        mav.addObject("users", userDTOList);
        return mav;
    }

    @PostMapping("/user/search")
    public ModelAndView search(SearchDTO dto) throws ExecutionException, JsonProcessingException, InterruptedException {
        ModelAndView mav = new ModelAndView("management_user");
        List<UserDTO> userDTOList = new ArrayList<>();
        switch (dto.getField()) {
            case "fullName":
                userDTOList = service.findUserByFullName(dto.getValue());
                break;
            case "department":
                userDTOList = service.findUserByDepartment(dto.getValue());
                break;
            case "gender":
                userDTOList = service.findUserByGender(dto.getValue());
                break;
            case "email":
                userDTOList = service.findUserByEmail(dto.getValue());
                break;
        }
        mav.addObject("users", userDTOList);

        return mav;
    }
}
