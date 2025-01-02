-- Dummy verilerle tabloyu doldur
INSERT INTO BSMGRIRPGEN001 (COM_CODE, COM_TEXT)
VALUES ('C001', 'Global Holdings A.Ş.'),
       ('C002', 'TechVision Teknoloji Ltd.'),
       ('C003', 'Ekinoks Yazılım ve Danışmanlık'),
       ('C004', 'Nokta İnşaat A.Ş.'),
       ('C005', 'Atlas Sigorta ve Reasürans A.Ş.');


INSERT INTO BSMGRIRPMAT001 (DOC_TYPE, DOC_TYPE_TEXT, IS_PASSIVE, COM_CODE_ID)
VALUES ('DT01', 'Fatura Belgesi', FALSE, 1),    -- Global Holdings A.Ş.
       ('DT02', 'Teklif Belgesi', TRUE, 1),     -- Global Holdings A.Ş.
       ('DT03', 'Sözleşme Belgesi', FALSE, 2),  -- TechVision Teknoloji Ltd.
       ('DT04', 'İrsaliye Belgesi', TRUE, 3),   -- Ekinoks Yazılım ve Danışmanlık
       ('DT05', 'Raporlama Belgesi', FALSE, 4), -- Nokta İnşaat A.Ş.
       ('DT06', 'Hizmet Belgesi', TRUE, 5);

INSERT INTO BSMGRIRPMAT001 (DOC_TYPE, DOC_TYPE_TEXT, IS_PASSIVE, COM_CODE_ID)
VALUES ('DT01', 'Fatura Belgesi', FALSE, 1),
       ('DT02', 'Teklif Belgesi', TRUE, 1),
       ('DT03', 'Sözleşme Belgesi', FALSE, 2),
       ('DT04', 'İrsaliye Belgesi', TRUE, 3),
       ('DT05', 'Raporlama Belgesi', FALSE, 4),
       ('DT06', 'Hizmet Belgesi', TRUE, 5);

INSERT INTO BSMGRIRPCCM001 (DOC_TYPE, DOC_TYPE_TEXT, IS_PASSIVE, COM_CODE_ID)
VALUES ('CC01', 'Muhasebe Masraf Merkezi', FALSE, 1),
       ('CC02', 'Üretim Masraf Merkezi', TRUE, 2),
       ('CC03', 'Satış Masraf Merkezi', FALSE, 3),
       ('CC04', 'Ar-Ge Masraf Merkezi', TRUE, 4),
       ('CC05', 'Lojistik Masraf Merkezi', FALSE, 5),
       ('CC06', 'İnsan Kaynakları Merkezi', TRUE, 1);

INSERT INTO BSMGRIRPBOM001 (DOC_TYPE, DOC_TYPE_TEXT, IS_PASSIVE, COM_CODE_ID)
VALUES ('BOM1', 'Üretim Ağacı - Elektronik', FALSE, 1),
       ('BOM2', 'Üretim Ağacı - Mekanik', TRUE, 2),
       ('BOM3', 'Üretim Ağacı - Kimyasal', FALSE, 3),
       ('BOM4', 'Üretim Ağacı - Tekstil', TRUE, 4),
       ('BOM5', 'Üretim Ağacı - Gıda', FALSE, 5),
       ('BOM6', 'Üretim Ağacı - Otomotiv', TRUE, 1);

INSERT INTO BSMGRIRPROT001 (DOC_TYPE, DOC_TYPE_TEXT, IS_PASSIVE, COM_CODE_ID)
VALUES ('RT01', 'Sevkiyat Rotası - Bölge 1', FALSE, 1),
       ('RT02', 'Sevkiyat Rotası - Bölge 2', TRUE, 2),
       ('RT03', 'Sevkiyat Rotası - Bölge 3', FALSE, 3),
       ('RT04', 'Sevkiyat Rotası - Bölge 4', TRUE, 4),
       ('RT05', 'Sevkiyat Rotası - Bölge 5', FALSE, 5),
       ('RT06', 'Sevkiyat Rotası - Bölge 6', TRUE, 1);

INSERT INTO BSMGRIRPWCM001 (DOC_TYPE, DOC_TYPE_TEXT, IS_PASSIVE, COM_CODE_ID)
VALUES ('WC01', 'İş Merkezi - Montaj', FALSE, 1),
       ('WC02', 'İş Merkezi - Kaynak', TRUE, 2),
       ('WC03', 'İş Merkezi - Boyama', FALSE, 3),
       ('WC04', 'İş Merkezi - Test', TRUE, 4),
       ('WC05', 'İş Merkezi - Paketleme', FALSE, 5),
       ('WC06', 'İş Merkezi - Sevkiyat', TRUE, 1);

INSERT INTO BSMGRIRPROT003 (DOC_TYPE, DOC_TYPE_TEXT, IS_PASSIVE, COM_CODE_ID)
VALUES ('OP01', 'Operasyon - Kesim', FALSE, 1),
       ('OP02', 'Operasyon - Delme', TRUE, 2),
       ('OP03', 'Operasyon - Şekillendirme', FALSE, 3),
       ('OP04', 'Operasyon - Kaynaklama', TRUE, 4),
       ('OP05', 'Operasyon - Montaj', FALSE, 5),
       ('OP06', 'Operasyon - Boyama', TRUE, 1);
