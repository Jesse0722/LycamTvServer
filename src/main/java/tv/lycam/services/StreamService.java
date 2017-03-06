package tv.lycam.services;

import lycamPlusSdk.lycam.model.LycamplusStream;
import lycamPlusSdk.lycam.model.ObjectListing;

/**
 * Created by jesse on 2017/3/4.
 */
public interface StreamService {
    LycamplusStream createStream(LycamplusStream stream);

    LycamplusStream findStreamById(String streamId);

    ObjectListing<LycamplusStream> listStreams();

    LycamplusStream updateStream(LycamplusStream stream);

    boolean destroyStream(String streamId);

    LycamplusStream createOrUpdateStream(LycamplusStream stream);
}
