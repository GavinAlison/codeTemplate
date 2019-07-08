package com.alison.winter.scray.repository;

import com.alison.winter.scray.domain.po.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends JpaRepository<App, Long> {

    App findByName(String name);
}
