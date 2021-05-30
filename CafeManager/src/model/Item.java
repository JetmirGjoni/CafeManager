package model;

public abstract class Item implements ItemSpecification{
    public String name , description , size , price, id;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSize() { return size; }

    public String getPrice() { return price; }

    public String getID(){
        return  id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String dscription) {
        this.description = description;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

}
