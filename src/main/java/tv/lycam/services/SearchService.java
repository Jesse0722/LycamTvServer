package tv.lycam.services;


import lycamPlusSdk.lycam.model.LycamplusStream;
import lycamPlusSdk.lycam.model.ObjectListing;
import tv.lycam.domain.*;

/**
 * Created by lycam on 16/4/27.
 */
public interface SearchService {

    SearchStreamsResponse searchStreams(SearchStreamsRequest searchStreamsRequest);

    SearchStreamsResponse searchUsers(SearchUsersRequest searchUsersRequest);

    SearchLocationResponse searchLoction(SearchLoctionRequest searchLoctionRequest);
    
    ObjectListing<LycamplusStream> sinceQuery();
}
