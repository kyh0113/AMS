package com.example.test.Asset.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class AssetStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    @Enumerated(EnumType.STRING)
    private AssetStatus status;  // 사용중, 반납됨, 보관중, 수리중, 폐기완료 등

    @Column(nullable = false)
    private LocalDate statusDate;  // 상태 시작일

    private String note;  // (선택) 상태 변경 사유나 설명
}