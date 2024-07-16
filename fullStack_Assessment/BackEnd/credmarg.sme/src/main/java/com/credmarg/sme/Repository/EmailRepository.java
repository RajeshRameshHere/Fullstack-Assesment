package com.credmarg.sme.Repository;

import com.credmarg.sme.Entity.EmailHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailHistory,Long> {

}
