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
public class goods {
    private int goodsId;
    private String goodsName;
    private String description;
    private String category;
    private float price;
    private int stockNumber;
    private String picPath;

    /**
     * @return the name
     */

    public goods() {
    }

    public goods(int id, String name, String description, String category, float price, int inStock, String picPath) {
        this.goodsId = id;
        this.goodsName = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.stockNumber = inStock;
        this.picPath = picPath;
    }

    
    public String getName() {
        return goodsName;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.goodsName = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the inStock
     */
    public int getInStock() {
        return stockNumber;
    }

    /**
     * @param inStock the inStock to set
     */
    public void setInStock(int inStock) {
        this.stockNumber = inStock;
    }

    /**
     * @return the picPath
     */
    public String getPicPath() {
        return picPath;
    }

    /**
     * @param picPath the picPath to set
     */
    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the id
     */
    public int getId() {
        return goodsId;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.goodsId = id;
    }
    
    
}
