package tv.lycam.domain;



import lycamPlusSdk.lycam.model.LycamplusStreamResponse;

import java.util.List;

/**
 * Created by lycam on 16/4/27.
 */
public class SearchLocationResponse {

    private int totalItems;//	纪录总数

    private int resultsPerPage;//	每页数量

    private boolean nextPageAvailable; //是否有下页

    private List<LycamplusStreamResponse> items; //	视频流清单
}
