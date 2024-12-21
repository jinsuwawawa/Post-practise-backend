package org.example.controller;

import org.example.model.Announcements;
import org.example.service.AnnouncementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info")
public class AnnouncementsController {

    @Autowired
    private AnnouncementsService announcementsService;

    // 发布公告
    @PostMapping("/post")
    public Announcements createAnnouncements(@RequestBody Announcements announcements) {
        return announcementsService.createAnnouncements(announcements);
    }

    // 获取所有公告
    @GetMapping("/list")
    public List<Announcements> getAllAnnouncements() {
        return announcementsService.getAllAnnouncementss();
    }

    // 获取单个公告
    @GetMapping("/{announcement_id}")
    public Announcements getAnnouncementById(@PathVariable Integer announcement_id) {
        return announcementsService.getAnnouncementById(announcement_id);
    }

    // 删除公告
    @DeleteMapping("/{announcement_id}")
    public void deleteAnnouncements(@PathVariable Integer announcement_id) {
        announcementsService.deleteAnnouncements(announcement_id);
    }
}