package com.example.campustrade.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.campustrade.entity.Message;

@Mapper
public interface MessageMapper {

    /**
     * メッセージIDからメッセージを取得する
     *
     * @param id メッセージID
     * @return メッセージ情報
     */
    Message findById(
            @Param("id") Long id
    );


    /**
     * 商品IDからメッセージ一覧を取得する
     *
     * 商品詳細画面の公開Q&Aや
     * 取引メッセージの表示に使用する
     *
     * @param productId 商品ID
     * @return メッセージ一覧
     */
    List<Message> findByProductId(
            @Param("productId") Long productId
    );


    /**
     * 商品IDと送信者・受信者を指定して
     * 非公開メッセージを取得する
     *
     * 取引成立後のメッセージ表示に使用する
     *
     * @param productId 商品ID
     * @param userId ログインユーザーID
     * @param otherUserId 相手ユーザーID
     * @return メッセージ一覧
     */
    List<Message> findPrivateMessages(
            @Param("productId") Long productId,
            @Param("userId") Long userId,
            @Param("otherUserId") Long otherUserId
    );


    /**
     * 自分が送信したメッセージを取得する
     *
     * @param senderId 送信者ID
     * @return メッセージ一覧
     */
    List<Message> findBySenderId(
            @Param("senderId") Long senderId
    );


    /**
     * 自分が受信したメッセージを取得する
     *
     * @param receiverId 受信者ID
     * @return メッセージ一覧
     */
    List<Message> findByReceiverId(
            @Param("receiverId") Long receiverId
    );


    /**
     * メッセージを新規登録する
     *
     * @param message 登録するメッセージ
     */
    void insert(Message message);


    /**
     * メッセージを削除する
     *
     * @param id メッセージID
     */
    void delete(
            @Param("id") Long id
    );

}
