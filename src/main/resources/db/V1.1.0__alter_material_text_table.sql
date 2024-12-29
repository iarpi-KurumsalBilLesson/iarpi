ALTER TABLE material_text
    ADD material_head_id INT;

ALTER TABLE material_text
    ADD CONSTRAINT fk_material_head FOREIGN KEY (material_head_id) REFERENCES material_head (ID) ON DELETE CASCADE;

