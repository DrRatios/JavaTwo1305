package ProdLike.impl;

import ProdLike.PublicationService;
import ProdLike.model.Publication;

public class DbPublicationService implements PublicationService {


    @Override
    public Publication getHotPublication() {
        return new Publication();
    }
}
