package com.kajarta.controller;

import java.util.List;

import com.kajarta.service.NoticeService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kajarta.demo.model.Notice;
import com.kajarta.util.DatetimeConverter;

@RestController
@RequestMapping("/front/notice")
@CrossOrigin
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    // 計算數量
    @GetMapping("/count")
    public long count() {
        return noticeService.count();
    }

    // 新增
    @PostMapping("/create")
    public String create(@RequestBody String body) {
        JSONObject responseBody = new JSONObject();
        JSONObject obj = new JSONObject(body);
        Notice card = noticeService.create(body);
        if (card == null) {
            responseBody.put("success", false);
            responseBody.put("message", "新增失敗");
        } else {
            responseBody.put("success", true);
            responseBody.put("message", "新增成功");
        }
        return responseBody.toString();
    }

    // 修改

    @PutMapping("/update/{id}")
    public String modify(@PathVariable Integer id, @RequestBody String body) {
        JSONObject responseBody = new JSONObject();
        if (id == null) {
            responseBody.put("success", false);
            responseBody.put("message", "Id是必要欄位");
        } else {
            if (!noticeService.exists(id)) {
                responseBody.put("success", false);
                responseBody.put("message", "Id不存在");
            } else {
                Notice product = noticeService.modify(body);
                if (product == null) {
                    responseBody.put("success", false);
                    responseBody.put("message", "修改失敗");
                } else {
                    responseBody.put("success", true);
                    responseBody.put("message", "修改成功");
                }
            }
        }
        return responseBody.toString();
    }

    // 查一
    @GetMapping("/select/{pk}")
    public String findById(@PathVariable(name = "pk") Integer id) {
        JSONObject responseBody = new JSONObject();
        JSONArray array = new JSONArray();

        Notice notice = noticeService.findById(id);
        if (notice != null) {
            String createTime = DatetimeConverter.toString(notice.getCreateTime(), "yyyy-MM-dd");
            String updateTime = DatetimeConverter.toString(notice.getUpdateTime(), "yyyy-MM-dd");
            Integer carId = (notice.getCar() != null) ? notice.getCar().getId() : null;
            Integer viewCarId = (notice.getViewCar() != null) ? notice.getViewCar().getId() : null;
            Integer viewCarAssignedId = (notice.getViewCarAssigned() != null) ? notice.getViewCarAssigned().getId()
                    : null;
            Integer preferenceId = (notice.getPreference() != null) ? notice.getPreference().getId() : null;
            JSONObject item = new JSONObject()
                    .put("id", notice.getId())
                    .put("category", notice.getCategory())
                    .put("createTime", createTime)
                    .put("updateTime", updateTime)
                    .put("viewableNotification", notice.getViewableNotification())
                    .put("readStatus", notice.getReadStatus())
                    .put("receiver", notice.getReceiver())
                    .put("accountType", notice.getAccountType())
                    .put("viewCar", viewCarId)
                    .put("viewCarAssigned", viewCarAssignedId)
                    .put("preference", preferenceId)
                    .put("car", carId);
            array = array.put(item);
        }
        responseBody.put("list", array);
        return responseBody.toString();
    }

    // 查全
    @GetMapping("/selectAll")
    public String findAll() {
        JSONObject responseBody = new JSONObject();
        JSONArray array = new JSONArray();
        List<Notice> notices = noticeService.findAll();
        for (Notice notice : notices) {
            String createTime = DatetimeConverter.toString(notice.getCreateTime(), "yyyy-MM-dd");
            String updateTime = DatetimeConverter.toString(notice.getUpdateTime(), "yyyy-MM-dd");
            Integer carId = (notice.getCar() != null) ? notice.getCar().getId() : null;
            Integer viewCarId = (notice.getViewCar() != null) ? notice.getViewCar().getId() : null;
            Integer viewCarAssignedId = (notice.getViewCarAssigned() != null) ? notice.getViewCarAssigned().getId()
                    : null;
            Integer preferenceId = (notice.getPreference() != null) ? notice.getPreference().getId() : null;
            JSONObject item = new JSONObject()
                    .put("id", notice.getId())
                    .put("category", notice.getCategory())
                    .put("createTime", createTime)
                    .put("updateTime", updateTime)
                    .put("viewableNotification", notice.getViewableNotification())
                    .put("readStatus", notice.getReadStatus())
                    .put("receiver", notice.getReceiver())
                    .put("accountType", notice.getAccountType())
                    .put("viewCar", viewCarId)
                    .put("viewCarAssigned", viewCarAssignedId)
                    .put("preference", preferenceId)
                    .put("car", carId);
            array.put(item);
        }
        long count = noticeService.count();
        responseBody.put("count", count);
        responseBody.put("list", array);
        return responseBody.toString();
    }

    // 多條件查詢
    // 刪除
    @DeleteMapping("/delete/{id}")
    public String remove(@PathVariable Integer id) {
        JSONObject responseBody = new JSONObject();
        if (id == null) {
            responseBody.put("success", false);
            responseBody.put("message", "Id是必要欄位");
        } else {
            if (!noticeService.exists(id)) {
                responseBody.put("success", false);
                responseBody.put("message", "Id不存在");
            } else {
                if (!noticeService.remove(id)) {
                    responseBody.put("success", false);
                    responseBody.put("message", "刪除失敗");
                } else {
                    responseBody.put("success", true);
                    responseBody.put("message", "刪除成功");
                }
            }
        }
        return responseBody.toString();
    }
}
