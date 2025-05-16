package ProdLike;

import ProdLike.model.Publication;

/**
 * Метод получения горячей(самой новиной) публикации
 */
public interface PublicationService {
    Publication getHotPublication();
}
