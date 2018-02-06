package daw.spring.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Home {

    @Id
    private long id;
    private long postCode;
    private String address;
    private HomeType typeHome;
    //
    @OneToMany()
    private List<Product> productList;
    //

    public Home() {
    }

    public Home(long id, long postCode, String address, HomeType typeHome, List<Product> productList) {
        this.id = id;
        this.postCode = postCode;
        this.address = address;
        this.typeHome = typeHome;
        this.productList = productList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPostCode() {
        return postCode;
    }

    public void setPostCode(long postCode) {
        this.postCode = postCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HomeType getTypeHome() {
        return typeHome;
    }

    public void setTypeHome(HomeType typeHome) {
        this.typeHome = typeHome;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public enum HomeType{
        ORDER, HOUSE   // ORDER ES UN PEDIDO, HOUSE ES CASA CONFIRMADA
    }

}

