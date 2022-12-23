package com.example.addbook.repository;

import com.example.addbook.dto.UserDTO;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    //db 연동 코드 입력
    static public ArrayList<UserDTO> users;

    static { //초기화
        users = new ArrayList<>();
        users.add(new UserDTO("유수빈", "id1", "1234", "990910", "010-1234-1234"));
        users.add(new UserDTO("홍길동", "id2", "1234", "931028", "010-2345-2345"));
        users.add(new UserDTO("김철수", "id3", "1234", "011206", "010-3456-3456"));
        users.add(new UserDTO("나영희", "id4", "1234", "950724", "010-4567-4567"));
    }

    //Create
    public UserDTO insertUser(UserDTO user) {
        users.add(user);
        return user;
    }

    //ReadAll
    public List<UserDTO> getAllUsers() {
        return users;
    }

    //ReadOne
    public UserDTO getUserByUserId(String userId) {
        return users.stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId)) //읽어온 userId와 같은 userId 정보 리턴
                .findAny()
                .orElse(new UserDTO("", "", "", "", "")); //없으면 null값 리턴
    }

    //Update
    public void updateUserAdd(String userId, UserDTO user) { //user - > 업데이트 할 객체
        users.stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDTO("", "", "", "", ""))
                .setPasswd(user.getPasswd());
    }

    //Delete
    public void deleteUser(String userId) {
        users.removeIf(userDTO -> userDTO.getUserId().equals(userId));
    }
}
