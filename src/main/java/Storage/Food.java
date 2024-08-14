package Storage;

import java.io.InputStream;

public class Food {
    //Food Items Table
    private int FoodID;
    private String FoodName;
    private String Category;
    private int Price;
    private String Description;
    private InputStream image;

    //Raw Material Table
    private int RawMaterialID;
    private String RawMaterialName;
    private double QuantityAvailable;
    private String Unit;
    private double ReorderLevel;
    private double PricePerUnit;

    //Food Ingredient Table
    private int FoodIngredientID;
    private int FoodID2;
    private int RawMaterialID2;
    private double QuantityRequired;

    public Food() {
    }

    public int getFoodID() {
        return FoodID;
    }

    public void setFoodID(int foodID) {
        FoodID = foodID;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getRawMaterialID() {
        return RawMaterialID;
    }

    public void setRawMaterialID(int rawMaterialID) {
        RawMaterialID = rawMaterialID;
    }

    public String getRawMaterialName() {
        return RawMaterialName;
    }

    public void setRawMaterialName(String rawMaterialName) {
        RawMaterialName = rawMaterialName;
    }

    public double getQuantityAvailable() {
        return QuantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        QuantityAvailable = quantityAvailable;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public double getReorderLevel() {
        return ReorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        ReorderLevel = reorderLevel;
    }

    public double getPricePerUnit() {
        return PricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        PricePerUnit = pricePerUnit;
    }

    public int getFoodIngredientID() {
        return FoodIngredientID;
    }

    public void setFoodIngredientID(int foodIngredientID) {
        FoodIngredientID = foodIngredientID;
    }

    public int getFoodID2() {
        return FoodID2;
    }

    public void setFoodID2(int foodID2) {
        FoodID2 = foodID2;
    }

    public int getRawMaterialID2() {
        return RawMaterialID2;
    }

    public void setRawMaterialID2(int rawMaterialID2) {
        RawMaterialID2 = rawMaterialID2;
    }

    public double getQuantityRequired() {
        return QuantityRequired;
    }

    public void setQuantityRequired(double quantityRequired) {
        QuantityRequired = quantityRequired;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "\n" +
                "FoodId = '" + FoodID +
                ",' Category = '" + Category +
                "', FoodName = '" + FoodName + "'\n" +
                "Price = Rs." + Price + "\n" +
                "Description = " + Description +
                "\n";
    }
}
