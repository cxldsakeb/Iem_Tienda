/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iem_tienda.service;

import com.iem_tienda.domain.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose1
 */
public interface ItemService {
    List<Item> listaItems = new ArrayList<>();

    public List<Item> gets();

    public Item get(Item item);

    public void delete(Item item);

    public void save(Item item);

    public void update(Item item);

    public void facturar();

}
