package com.example.campustrade.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.campustrade.entity.User;

@Mapper
public interface UserMapper {

    /**
     * 学生番号からユーザーを検索
     *
     * @param studentNumber 学生番号
     * @return ユーザー情報
     */
    User findByStudentNumber(
            @Param("studentNumber") String studentNumber
    );

    /**
     * ユーザーIDからユーザーを検索
     *
     * @param userId ユーザーID
     * @return ユーザー情報
     */
    User findById(
            @Param("userId") Long userId
    );

    /**
     * 学生番号がすでに登録されているか確認
     *
     * @param studentNumber 学生番号
     * @return 登録されている場合は1、いない場合は0
     */
    int countByStudentNumber(
            @Param("studentNumber") String studentNumber
    );

    /**
     * 新規ユーザー登録
     *
     * @param user 登録するユーザー
     */
    void insert(User user);

    /**
     * ユーザー情報を更新
     *
     * @param user 更新するユーザー
     */
    void update(User user);

}
