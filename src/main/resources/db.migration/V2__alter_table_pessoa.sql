-- 1) Adicionar coluna tipo_pessoa
ALTER TABLE pessoa
ADD COLUMN tipo_pessoa VARCHAR(20);

-- 2) Preencher com FISICA onde existe relação com pessoa_fisica
UPDATE pessoa p
SET tipo_pessoa = 'FISICA'
WHERE EXISTS (
    SELECT 1
    FROM pessoa_fisica pf
    WHERE pf.id = p.id
);

-- 3) Preencher com JURIDICA onde existe relação com pessoa_juridica
UPDATE pessoa p
SET tipo_pessoa = 'JURIDICA'
WHERE EXISTS (
    SELECT 1
    FROM pessoa_juridica pj
    WHERE pj.id = p.id
);

-- 4) Opcional: tornar NOT NULL após ter valores para todos
ALTER TABLE pessoa
ALTER COLUMN tipo_pessoa SET NOT NULL;
