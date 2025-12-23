
package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.LifecycleEvent;

public interface LifecycleEventRepository extends JpaRepository<LifecycleEvent, Long> {

    List<LifecycleEvent> findByAsset_Id(Long assetId);

}
