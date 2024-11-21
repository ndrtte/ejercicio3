package hn.unah.poo.ejercicio3.ModelMapper;

import org.modelmapper.ModelMapper;

public class ModelMapperSingleton {
    private static ModelMapper modelMapper;

    private ModelMapperSingleton(){

    }

    public static ModelMapper getInstancia (){
        if(modelMapper==null){
            modelMapper = new ModelMapper();
        }
        return modelMapper;
    }
}
