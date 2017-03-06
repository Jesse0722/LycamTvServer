package tv.lycam.domain;



import lycamPlusSdk.lycam.model.LycamplusStreamResponse;

import java.util.List;

/**
 * Created by lycam on 16/4/27.
 */
public class SearchStreamsResponse {
    private int totalItems;//	int	纪录总数
    private int resultsPerPage;//	integer	每页数量
    private int pageNumber; //	是否有下页
    private boolean nextPageAvailable; //是否有下页
    private List<LycamplusStreamResponse> items;//	array	视频流清单

}
