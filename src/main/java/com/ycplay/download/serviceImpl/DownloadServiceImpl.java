package com.ycplay.download.serviceImpl;

import com.ycplay.download.mapper.DownloadMapper;
import com.ycplay.download.model.Download;
import com.ycplay.download.response.Response;
import com.ycplay.download.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @CreateTime:2018/3/26 11:37
 * @Author:Administrator
 * @Version:v-1.0.0
 * @Comment: 下载服务实现
 */

@Service
public class DownloadServiceImpl implements DownloadService {

    @Autowired
    private DownloadMapper downloadMapper;

    @Override
    public void addDownload(Download download) {
        downloadMapper.addDownload(download);
    }

    @Override
    public Response retainAccess(String beginTime, String endTime) {
        return downloadMapper.statistics(beginTime, endTime);
    }
}
