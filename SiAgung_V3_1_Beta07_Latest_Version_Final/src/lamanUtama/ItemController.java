package lamanUtama;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.Main;
import main.MyListener;
import model.Barang;

public class ItemController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;

    @FXML
    private ImageView img;

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(fruit);
    }

    private Barang fruit;
    private MyListener myListener;

   public void setData(Barang fruit, MyListener myListener) {
        this.fruit = fruit;
        this.myListener = myListener;
        nameLabel.setText(fruit.getName());
        priceLable.setText("IDR " + fruit.getPrice());
        
        if(fruit.getImgSrc().equals("")){
        } else {
            Image image;
            if(fruit.getOri()){
                image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
            }else{
                image = new Image(fruit.getImgSrc());
            }
                img.setImage(image);
            
        }
        
        
    }
}
