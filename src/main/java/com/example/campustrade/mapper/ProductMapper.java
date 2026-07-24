package com.example.campustrade.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.campustrade.entity.Product;

@Mapper
public interface ProductMapper {

    /**
     * 商品IDから商品を検索する
     *
     * @param productId 商品ID
     * @return 商品情報
     */
    Product findById(
            @Param("productId") Long productId
    );


    /**
     * すべての商品を新着順で取得する
     *
     * @return 商品一覧
     */
    List<Product> findAll();


    /**
     * 販売中の商品を新着順で取得する
     *
     * @return 販売中の商品一覧
     */
    List<Product> findOpenProducts();


    /**
     * キーワードとカテゴリを指定して商品を検索する
     *
     * @param keyword 商品名・説明の検索キーワード
     * @param categoryId カテゴリID
     * @return 検索結果
     */
    List<Product> search(
            @Param("keyword") String keyword,
            @Param("categoryId") Long categoryId
    );


    /**
     * 商品を新規登録する
     *
     * @param product 登録する商品
     */
    void insert(Product product);


    /**
     * 商品情報を更新する
     *
     * @param product 更新する商品
     */
    void update(Product product);


    /**
     * 商品を削除する
     *
     * @param productId 商品ID
     */
    void delete(
            @Param("productId") Long productId
    );


    /**
     * 商品のステータスを変更する
     *
     * OPEN
     * LOCKED
     * CLOSED
     *
     * @param productId 商品ID
     * @param status 新しいステータス
     */
    void updateStatus(
            @Param("productId") Long productId,
            @Param("status") String status
    );


    /**
     * 商品の購入者を設定する
     *
     * @param productId 商品ID
     * @param purchaserId 購入者のユーザーID
     */
    void updatePurchaser(
            @Param("productId") Long productId,
            @Param("purchaserId") Long purchaserId
    );


    /**
     * 商品を購入者設定と同時にLOCKEDへ変更する
     *
     * 購入処理で使用する
     *
     * @param productId 商品ID
     * @param purchaserId 購入者ID
     * @return 更新された件数
     */
    int lockProduct(
            @Param("productId") Long productId,
            @Param("purchaserId") Long purchaserId
    );


    /**
     * IDを指定して商品を削除する
     *
     * @param productId 商品ID
     */
    void deleteById(
            @Param("productId") Long productId
    );


    /**
     * 出品者IDから自分の出品商品を取得する
     *
     * @param sellerId 出品者ID
     * @return 出品商品一覧
     */
    List<Product> findBySellerId(
            @Param("sellerId") Long sellerId
    );


    /**
     * 購入者IDから購入した商品を取得する
     *
     * @param purchaserId 購入者ID
     * @return 購入商品一覧
     */
    List<Product> findByPurchaserId(
            @Param("purchaserId") Long purchaserId
    );


    /**
     * ステータスを指定して商品を取得する
     *
     * 管理者画面で使用する
     *
     * @param status 商品ステータス
     * @return 商品一覧
     */
    List<Product> findByStatus(
            @Param("status") String status
    );


    /**
     * 管理者が禁止商品に設定する
     *
     * @param productId 商品ID
     */
    void banProduct(
            @Param("productId") Long productId
    );


    /**
     * 管理者が禁止を解除する
     *
     * @param productId 商品ID
     */
    void unbanProduct(
            @Param("productId") Long productId
    );

}
