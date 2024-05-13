package ProdLike;

import ProdLike.impl.CashedPublicationService;
import ProdLike.impl.DbPublicationService;

public class ProdApp {
    public static void main(String[] args) {
        PublicationService publicationService = new CashedPublicationService(new DbPublicationService().getHotPublication());

        for (int i =0;i<1000;i++){
            System.out.println(publicationService.getHotPublication());
        }

        //много кода с использованием publicationService
    }


}
