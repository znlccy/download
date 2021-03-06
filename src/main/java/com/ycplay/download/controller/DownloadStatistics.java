package com.ycplay.download.controller;

import com.ycplay.download.model.Download;
import com.ycplay.download.request.Request;
import com.ycplay.download.response.Response;
import com.ycplay.download.service.DownloadService;
import com.ycplay.download.util.IPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * @CreateTime:2018/3/26 11:19
 * @Author:Administrator
 * @Version:v-1.0.0
 * @Comment: 下载统计
 */

@Controller
public class DownloadStatistics {

    /**
     * 声明下载服务
     */
    @Autowired
    private DownloadService downloadService;

    /**
     * @comment: download 实现下载链接
     * @param: [request, response]
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @GetMapping(value = "/")
    public ModelAndView download(HttpServletRequest request)  {
        String uid = request.getParameter("game");
        /*String url = "redirect:https://play.google.com/store/apps/details?id="+uid;*/
        String url = "redirect:https://play.google.com/store/apps/details?id=com.ycplay.tankmania";
        final Download download = new Download();
        download.setIp(IPUtil.getIpAddr(request));
        download.setTime(new Timestamp(System.currentTimeMillis()));
        download.setUid("com.ycplay.tankmania");
        download.setPlatform("Android");

        new Thread(
            new Runnable() {
                @Override
                public void run() {
                    downloadService.addDownload(download);
                }
            }
        ).start();
        return new ModelAndView(url);
    }

    @PostMapping(value = "/statistics")
    @ResponseBody
    public Map<String, Object> statistic(@RequestBody Request request) {
        Map<String, Object> map = new HashMap<String, Object>();
        Response response = downloadService.retainAccess(request.getBeginTime(), request.getEndTime());
        map.put("code", "1200");
        map.put("message","Success");
        map.put("data",response);
        return map;
    }
}
