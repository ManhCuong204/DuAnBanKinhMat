/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;
import model.ThuocTinh;

/**
 *
 * @author nguyen cuong
 */
public class thuoctinhdao {
    ArrayList<ThuocTinh> list = new ArrayList<>();
    public thuoctinhdao(){
        list.add(new ThuocTinh("ph01", "abc"));
        list.add(new ThuocTinh("ph02", "abce"));
        list.add(new ThuocTinh("ph03", "abcd"));
        
    }
    public ArrayList<ThuocTinh> getAll(){
        return list;
    }
    public boolean add(ThuocTinh tt ){
        list.add(tt);
        return true;
    }
}
