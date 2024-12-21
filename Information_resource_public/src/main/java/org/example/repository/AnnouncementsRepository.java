package org.example.repository;

import org.example.model.Announcements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementsRepository extends JpaRepository<Announcements, Integer> {
}