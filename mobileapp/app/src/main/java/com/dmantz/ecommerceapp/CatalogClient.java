package com.dmantz.ecommerceapp;


import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import org.json.JSONArray;
import org.json.JSONObject;


public class CatalogClient extends ProductList{



     static CatalogClient catalogclientObj;
    private ProductList productList;

    private CatalogClient(){

    }



    //JSONObject jsonObj = new JSONObject();

    //JSONObject storejsonObj= null;

    String catalogURL="http://192.168.100.4:8080/UserApp/catalog";

    public  static CatalogClient getCatalogClient(){

        if(catalogclientObj==null) {
            catalogclientObj = new CatalogClient();
        }
        return catalogclientObj;
    }


    public ProductList productDisplayList() throws Exception {

        URL url = new URL(catalogURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("content-Type", "application/json");
        //connection.setDoInput(true);
        //connection.setDoOutput(true);

        BufferedReader bufferedresponse = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuffer response = new StringBuffer();
        while ((line = bufferedresponse.readLine()) != null) {
            response.append(line);
            response.append("/r");
        }
        bufferedresponse.close();


        JSONObject storejsonObj = new JSONObject(response.toString());
        //List listObj = new ArrayList();
        JSONArray jsonarrayObj = storejsonObj.getJSONArray("Catalog");

        Log.d("jsonarray", "products" + jsonarrayObj);

        productList = new ProductList();
        ArrayList<Product> products = new ArrayList<>();

        //ProductList productlistObj = new ProductList();
        for (int i = 0; i < jsonarrayObj.length(); i++) {

            //System.out.println("itemName: "+jsonarrayObj.getJSONObject(i).get("item_name"));
            Product currentProduct = new Product();

            currentProduct.setItemName((String) jsonarrayObj.getJSONObject(i).get("item_name"));
            currentProduct.setItemSize((String) jsonarrayObj.getJSONObject(i).get("item_size"));
            currentProduct.setItemPrice((double) jsonarrayObj.getJSONObject(i).get("item_price"));
            Log.d("catalog","item-name"+currentProduct.getItemName());
            products.add(currentProduct);
            // Log.d("full ","fjdhkgr"+listObj.get);
        }
        productList.setProductList(products);

       //ProductList productObj = (ProductList) listObj.get(1);
     // Log.d("Result", "size of " + productObj.getItemName());
        return productList;

      /*  for(Object Obj:listObj) {
            ProductList productObj=(ProductList)Obj;
           // System.out.println("itemName is: "+productObj.getItemName() + " itemSize is: "+productObj.getItemSize() + " itemPrice is: "+productObj.getItemPrice());
          Log.d("full","name"+.getItemName());



    }
     */
    }


    }