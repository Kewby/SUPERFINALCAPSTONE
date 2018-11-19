/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashierpage;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import login.LoginController;
import models.ProductModel;
import models.SalesModel;
import models.TransactionModel;
/**
 *
 * @author Allysha, Kirby
 */
public class ReceivePaymentController {
   
  
   public class TransItem{
        int transId;
        int transQty;
        int prodId; //product id to product code
        float uPrice; //unit price
        float sTotal; //subtotal
        
        
        public int getTransId() {
            return transId;
        }

        public void setTransId(int transId) {
            this.transId = transId;
        }

        public int getTransQty() {
            return transQty;
        }

        public void setTransQty(int transQty) {
            this.transQty = transQty;
        }

        public int getProdId() {
            return prodId;
        }

        public void setProdId(int prodId) {
            this.prodId = prodId;
        }

        public float getuPrice() {
            return uPrice;
        }

        public void setuPrice(float uPrice) {
            this.uPrice = uPrice;
        }

        public float getsTotal() {
            return sTotal;
        }

        public void setsTotal(float sTotal) {
            this.sTotal = sTotal;
        }

        
    }
  
   TransactionModel tm = new TransactionModel();
   public void getOrder(int indx,DefaultTableModel model){ 
       TransItem[] trans = new TransItem[50];
       int i = 0;
       System.out.println("OK transaction"+indx);
       for(i=0; i<model.getRowCount();i++){
           trans[i] = new TransItem();
           trans[i].setProdId(Integer.parseInt(String.valueOf(model.getValueAt(i,0))));
           trans[i].setTransId(indx);
           trans[i].setTransQty(Integer.parseInt(String.valueOf(model.getValueAt(i, 2))));
           trans[i].setuPrice(Float.parseFloat(String.valueOf(model.getValueAt(i,3))));
           trans[i].setsTotal(Float.parseFloat(String.valueOf(model.getValueAt(i,4))));

           tm.addItem(trans[i]);
       }
       
       
   }
}
