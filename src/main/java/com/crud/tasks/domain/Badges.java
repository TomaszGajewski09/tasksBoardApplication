package com.crud.tasks.domain;


import jakarta.transaction.Transactional;
import lombok.*;


@Getter
public class Badges {
    private int votes;
    AttachmentsByType attachmentsByType;
}
