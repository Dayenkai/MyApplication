package com.example.myapplication.Controller;

import com.example.myapplication.Model.Sandwich;

import java.util.List;

public class RestSandwichResponse {

    private List<Sandwich> sandwich;

    public void setSandwiches(List<Sandwich> sandwich) {
        this.sandwich = sandwich;
    }

    public List<Sandwich> getSandwiches() {
        return sandwich;
    }
}
