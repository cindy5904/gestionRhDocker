CREATE DATABASE IF NOT EXISTS gestionrh;

USE gestionrh;

CREATE TABLE Candidat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    numeroIdentification VARCHAR(50) UNIQUE NOT NULL,
    adresse VARCHAR(255),
    telephone VARCHAR(20),
    email VARCHAR(255) UNIQUE,
    dateNaissance DATE,
    evaluation DOUBLE,
    observation TEXT,
    competence VARCHAR(255),
    domaineTechnique VARCHAR(255),
    dateEntretien DATE
);

-- Création de la table si elle n'existe pas
CREATE TABLE Employe (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    numeroIdentification VARCHAR(50) UNIQUE NOT NULL,
    adresse VARCHAR(255),
    telephone VARCHAR(20),
    email VARCHAR(255) UNIQUE,
    dateNaissance DATE,
    debutContrat DATE,
    finContrat DATE,
    poste VARCHAR(255),
    motDePasse VARCHAR(255),
    admin BOOLEAN,
    salaire DOUBLE,
    observation TEXT
);


INSERT INTO Candidat (
    nom, numeroIdentification, adresse, telephone, email, dateNaissance, evaluation, observation, competence, domaineTechnique, dateEntretien
) VALUES
    ('Jean Dupont', 'ID001', '10 Rue de la Paix, 75001 Paris', '0102030405', 'jean.dupont@example.com', '1985-05-15', 85.5, 'Très bon entretien', 'Développeur Java', 'Backend', '2024-07-25'),
    ('Marie Curie', 'ID002', '20 Avenue des Champs-Élysées, 75008 Paris', '0607080910', 'marie.curie@example.com', '1990-03-10', 90.0, 'Entretien excellent', 'Ingénieur Data', 'Data Science', '2024-07-26'),
    ('Albert Einstein', 'ID003', '30 Boulevard Saint-Germain, 75005 Paris', '0203040506', 'albert.einstein@example.com', '1979-01-20', 78.0, 'Bon potentiel', 'Physicien', 'Recherche', '2024-07-27'),
    ('Ada Lovelace', 'ID004', '40 Rue du Louvre, 75001 Paris', '0708091011', 'ada.lovelace@example.com', '1815-12-10', 88.0, 'Très bonne analyse', 'Mathematicienne', 'Algorithmique', '2024-07-28'),
    ('Alan Turing', 'ID005', '50 Boulevard Montmartre, 75002 Paris', '0809101112', 'alan.turing@example.com', '1912-06-23', 92.0, 'Excellente compréhension', 'Cryptanalyste', 'Cryptographie', '2024-07-29');

INSERT INTO Employe (
    nom, numeroIdentification, adresse, telephone, email, dateNaissance, debutContrat, finContrat, poste, motDePasse, admin, salaire, observation
) VALUES
    ('Jean Dupont', 'EMP001', '10 Rue de la Paix, 75001 Paris', '0102030405', 'jean.dupont@example.com', '1980-07-15', '2024-01-01', '2024-12-31', 'Développeur Java', 'password123', FALSE, 3500.0, 'Employé performant'),
    ('Marie Curie', 'EMP002', '20 Avenue des Champs-Élysées, 75008 Paris', '0607080910', 'marie.curie@example.com', '1985-03-10', '2024-02-01', '2024-12-31', 'Ingénieur Data', 'password456', TRUE, 4000.0, 'Expert en data science'),
    ('Albert Einstein', 'EMP003', '30 Boulevard Saint-Germain, 75005 Paris', '0203040506', 'albert.einstein@example.com', '1975-12-20', '2024-03-01', '2025-03-01', 'Physicien', 'password789', FALSE, 3700.0, 'Chercheur talentueux'),
    ('Ada Lovelace', 'EMP004', '40 Rue du Louvre, 75001 Paris', '0708091011', 'ada.lovelace@example.com', '1815-12-10', '2024-04-01', '2024-12-31', 'Mathematicienne', 'password101', FALSE, 3600.0, 'Bonne analyse mathématique'),
    ('Alan Turing', 'EMP005', '50 Boulevard Montmartre, 75002 Paris', '0809101112', 'alan.turing@example.com', '1912-06-23', '2024-05-01', '2025-05-01', 'Cryptanalyste', 'password202', TRUE, 4100.0, 'Excellent en cryptographie');    