/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseRelated;

/**
 *
 * @author zhou6718
 */
public class orderDetails {
    private int orderId;
    private int userId;
    private int goodsId;
    private int goodsNumber;
    private String isShipped;

    public orderDetails() {
    }

    public orderDetails(int orderId, int userId, int goodsId, int goodsNumber,String isShipped) {
        this.orderId = orderId;
        this.userId = userId;
        this.goodsId = goodsId;
        this.goodsNumber = goodsNumber;
        this.isShipped = isShipped;
    }

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the goodsId
     */
    public int getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId the goodsId to set
     */
    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return the goodsNumber
     */
    public int getGoodsNumber() {
        return goodsNumber;
    }

    /**
     * @param goodsNumber the goodsNumber to set
     */
    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    /**
     * @return the isShipped
     */
    public String getIsShipped() {
        return isShipped;
    }

    /**
     * @param isShipped the isShipped to set
     */
    public void setIsShipped(String isShipped) {
        this.isShipped = isShipped;
    }
    
}
