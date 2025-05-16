package ProdLike.impl;

import ProdLike.PublicationService;
import ProdLike.model.Publication;

public class CashedPublicationService implements PublicationService {
    private final Publication publication;

    public CashedPublicationService(Publication publication) {
        this.publication = publication;
    }

    @Override
    public Publication getHotPublication() {
        return null;
    }
}
