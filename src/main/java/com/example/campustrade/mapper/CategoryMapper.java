package com.example.campustrade.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import aQute.bnd.annotation.headers.Category;

@Mapper
public interface CategoryMapper {

    /**
     * すべてのカテゴリを取得する
     *
     * @return カテゴリ一覧
     */
    List<Category> findAll();


    /**
     * カテゴリIDからカテゴリを取得する
     *
     * @param categoryId カテゴリID
     * @return カテゴリ情報
     */
    Category findById(
            @Param("categoryId") Long categoryId
    );


    /**
     * カテゴリを新規登録する
     *
     * 管理者機能で使用
     *
     * @param category 登録するカテゴリ
     */
    void insert(Category category);


    /**
     * カテゴリ名を更新する
     *
     * 管理者機能で使用
     *
     * @param category 更新するカテゴリ
     */
    void update(Category category);


    /**
     * カテゴリを削除する
     *
     * 管理者機能で使用
     *
     * @param categoryId カテゴリID
     */
    void delete(
            @Param("categoryId") Long categoryId
    );

}
