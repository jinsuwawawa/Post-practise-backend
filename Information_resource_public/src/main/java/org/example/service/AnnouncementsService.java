package org.example.service;

import org.example.model.Announcements;
import org.example.repository.AnnouncementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AnnouncementsService {

    @Autowired
    private AnnouncementsRepository announcementsRepository;

    // 创建公告
    public Announcements createAnnouncements(Announcements announcements) {
        return announcementsRepository.save(announcements);
    }

    // 获取所有公告
    public List<Announcements> getAllAnnouncementss() {
        return announcementsRepository.findAll();
    }

    // 删除公告
    public void deleteAnnouncements(Integer announcement_id) {
        announcementsRepository.deleteById(announcement_id);
    }

    // 根据 ID 获取单个公告
    public Announcements getAnnouncementById(Integer announcement_id) {
        return announcementsRepository.findById(announcement_id)
                .orElseThrow(() -> new RuntimeException("Announcement not found with id: " + announcement_id));
    }
}