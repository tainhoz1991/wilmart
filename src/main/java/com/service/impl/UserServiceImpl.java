package com.service.impl;

import com.dto.UserDTO;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.UserService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    private final ReplyingKafkaTemplate<String, Object, Object> replyKafkaTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public UserServiceImpl(ReplyingKafkaTemplate<String, Object, Object> replyKafkaTemplate) {
        this.replyKafkaTemplate = replyKafkaTemplate;
    }

    @Override
    public List<UserDTO> getAllUsers() throws ExecutionException, InterruptedException, IOException {
        ProducerRecord<String, Object> record = new ProducerRecord<>("get_list_users", "");
        RequestReplyFuture<String, Object, Object> sendAndReceive = replyKafkaTemplate.sendAndReceive(record);
        SendResult<String, Object> sendResult = sendAndReceive.getSendFuture().get();
        sendResult.getProducerRecord().headers().forEach(header -> System.out.println(header.key() + ":" + header.value().toString()));
        ConsumerRecord<String, Object> consumerRecord = sendAndReceive.get();

        String json = (String) consumerRecord.value();

        List<UserDTO> userDTOList = objectMapper.readValue(json, new TypeReference<List<UserDTO>>(){});
        return userDTOList;
    }

    @Override
    public Object test() throws ExecutionException, InterruptedException {
        ProducerRecord<String, Object> record = new ProducerRecord<>("users", "");
        RequestReplyFuture<String, Object, Object> sendAndReceive = replyKafkaTemplate.sendAndReceive(record);
        SendResult<String, Object> sendResult = sendAndReceive.getSendFuture().get();
        sendResult.getProducerRecord().headers().forEach(header -> System.out.println(header.key() + ":" + header.value().toString()));
        ConsumerRecord<String, Object> consumerRecord = sendAndReceive.get();

        return consumerRecord.value();
    }

    @Override
    public UserDTO create(UserDTO dto) throws JsonProcessingException, ExecutionException, InterruptedException {
        String jsonDto = objectMapper.writeValueAsString(dto);
        ProducerRecord<String, Object> record = new ProducerRecord<>("create_user", jsonDto);
        RequestReplyFuture<String, Object, Object> sendAndReceive = replyKafkaTemplate.sendAndReceive(record);
        SendResult<String, Object> sendResult = sendAndReceive.getSendFuture().get();
        sendResult.getProducerRecord().headers().forEach(header -> System.out.println(header.key() + ":" + header.value().toString()));
        ConsumerRecord<String, Object> consumerRecord = sendAndReceive.get();

        String json = (String) consumerRecord.value();

        UserDTO userDTO = objectMapper.readValue(json, new TypeReference<UserDTO>(){});
        return userDTO;
    }

    @Override
    public UserDTO update(UserDTO dto) throws ExecutionException, InterruptedException, JsonProcessingException {
        String jsonDto = objectMapper.writeValueAsString(dto);
        ProducerRecord<String, Object> record = new ProducerRecord<>("update_user", jsonDto);
        RequestReplyFuture<String, Object, Object> sendAndReceive = replyKafkaTemplate.sendAndReceive(record);
        SendResult<String, Object> sendResult = sendAndReceive.getSendFuture().get();
        sendResult.getProducerRecord().headers().forEach(header -> System.out.println(header.key() + ":" + header.value().toString()));
        ConsumerRecord<String, Object> consumerRecord = sendAndReceive.get();

        String json = (String) consumerRecord.value();

        UserDTO userDTO = objectMapper.readValue(json, new TypeReference<UserDTO>(){});
        return userDTO;
    }

    @Override
    public List<UserDTO> findUserByEmail(String email) throws JsonProcessingException, ExecutionException, InterruptedException {
        ProducerRecord<String, Object> record = new ProducerRecord<>("get_list_users", email);
        RequestReplyFuture<String, Object, Object> sendAndReceive = replyKafkaTemplate.sendAndReceive(record);
        SendResult<String, Object> sendResult = sendAndReceive.getSendFuture().get();
        sendResult.getProducerRecord().headers().forEach(header -> System.out.println(header.key() + ":" + header.value().toString()));
        ConsumerRecord<String, Object> consumerRecord = sendAndReceive.get();

        String json = (String) consumerRecord.value();

        List<UserDTO> userDTOList = objectMapper.readValue(json, new TypeReference<List<UserDTO>>(){});
        return userDTOList;
    }

    @Override
    public List<UserDTO> findUserByGender(String gender) throws JsonProcessingException, ExecutionException, InterruptedException {
        ProducerRecord<String, Object> record = new ProducerRecord<>("get_list_users", "");
        RequestReplyFuture<String, Object, Object> sendAndReceive = replyKafkaTemplate.sendAndReceive(record);
        SendResult<String, Object> sendResult = sendAndReceive.getSendFuture().get();
        sendResult.getProducerRecord().headers().forEach(header -> System.out.println(header.key() + ":" + header.value().toString()));
        ConsumerRecord<String, Object> consumerRecord = sendAndReceive.get();

        String json = (String) consumerRecord.value();

        List<UserDTO> userDTOList = objectMapper.readValue(json, new TypeReference<List<UserDTO>>(){});
        return userDTOList;
    }

    @Override
    public List<UserDTO> findUserByFullName(String fullName) throws JsonProcessingException, ExecutionException, InterruptedException {
        ProducerRecord<String, Object> record = new ProducerRecord<>("get_list_users", "");
        RequestReplyFuture<String, Object, Object> sendAndReceive = replyKafkaTemplate.sendAndReceive(record);
        SendResult<String, Object> sendResult = sendAndReceive.getSendFuture().get();
        sendResult.getProducerRecord().headers().forEach(header -> System.out.println(header.key() + ":" + header.value().toString()));
        ConsumerRecord<String, Object> consumerRecord = sendAndReceive.get();

        String json = (String) consumerRecord.value();

        List<UserDTO> userDTOList = objectMapper.readValue(json, new TypeReference<List<UserDTO>>(){});
        return userDTOList;
    }

    @Override
    public List<UserDTO> findUserByDepartment(String department) throws JsonProcessingException, ExecutionException, InterruptedException {
        ProducerRecord<String, Object> record = new ProducerRecord<>("get_list_users", "");
        RequestReplyFuture<String, Object, Object> sendAndReceive = replyKafkaTemplate.sendAndReceive(record);
        SendResult<String, Object> sendResult = sendAndReceive.getSendFuture().get();
        sendResult.getProducerRecord().headers().forEach(header -> System.out.println(header.key() + ":" + header.value().toString()));
        ConsumerRecord<String, Object> consumerRecord = sendAndReceive.get();

        String json = (String) consumerRecord.value();

        List<UserDTO> userDTOList = objectMapper.readValue(json, new TypeReference<List<UserDTO>>(){});
        return userDTOList;
    }

    @Override
    public Boolean delete(UserDTO dto) throws ExecutionException, InterruptedException, JsonProcessingException {
        String jsonDto = objectMapper.writeValueAsString(dto);
        ProducerRecord<String, Object> record = new ProducerRecord<>("delete_user", jsonDto);
        RequestReplyFuture<String, Object, Object> sendAndReceive = replyKafkaTemplate.sendAndReceive(record);
        SendResult<String, Object> sendResult = sendAndReceive.getSendFuture().get();
        sendResult.getProducerRecord().headers().forEach(header -> System.out.println(header.key() + ":" + header.value().toString()));
        ConsumerRecord<String, Object> consumerRecord = sendAndReceive.get();

        Boolean result = (Boolean) consumerRecord.value();

//        UserDTO userDTO = objectMapper.readValue(json, new TypeReference<UserDTO>(){});
        return result;
    }

    @Override
    public UserDTO findUserById(String userId) throws JsonProcessingException, ExecutionException, InterruptedException {
        ProducerRecord<String, Object> record = new ProducerRecord<>("get_list_users", "");
        RequestReplyFuture<String, Object, Object> sendAndReceive = replyKafkaTemplate.sendAndReceive(record);
        SendResult<String, Object> sendResult = sendAndReceive.getSendFuture().get();
        sendResult.getProducerRecord().headers().forEach(header -> System.out.println(header.key() + ":" + header.value().toString()));
        ConsumerRecord<String, Object> consumerRecord = sendAndReceive.get();

        String json = (String) consumerRecord.value();

        UserDTO userDTO = objectMapper.readValue(json, new TypeReference<UserDTO>(){});
        return userDTO;
    }
}
