package com.service;

import com.dto.UserBaseDTO;
import com.dto.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface UserService {
    List<UserDTO> getAllUsers() throws ExecutionException, InterruptedException, IOException;

    Object test() throws ExecutionException, InterruptedException;

    List<UserDTO> create(UserBaseDTO dto) throws JsonProcessingException, ExecutionException, InterruptedException;

    List<UserDTO> update(UserDTO dto) throws ExecutionException, InterruptedException, JsonProcessingException;

    List<UserDTO> findUserByEmail(String email) throws JsonProcessingException, ExecutionException, InterruptedException;

    List<UserDTO> findUserByGender(String gender) throws JsonProcessingException, ExecutionException, InterruptedException;

    List<UserDTO> findUserByFullName(String fullName) throws JsonProcessingException, ExecutionException, InterruptedException;

    List<UserDTO> findUserByDepartment(String department) throws JsonProcessingException, ExecutionException, InterruptedException;

    List<UserDTO> delete(String userId) throws ExecutionException, InterruptedException, JsonProcessingException;

    UserDTO findUserById(String userId) throws JsonProcessingException, ExecutionException, InterruptedException;
}
