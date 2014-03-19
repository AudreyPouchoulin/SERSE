-- BASE DONNEES serse : insertion de données de test
-- Auteurs : Clara Doucoure et Audrey Pouchoulin
-- Date création : 30/01/2014
-- Date dernière modification : 15/04/2014
-- Version : 3

--  des types d'expérience
INSERT INTO  serse.typeExperience (typeExperience_id, typeExperience_libelle) VALUES (1, 'académique');
INSERT INTO  serse.typeExperience (typeExperience_id, typeExperience_libelle) VALUES (2, 'professionnelle');

--  des types de séjour
INSERT INTO  serse.typeSejour (typeSejour_id, typeSejour_libelle) VALUES (1, 'université');
INSERT INTO  serse.typeSejour (typeSejour_id, typeSejour_libelle) VALUES (2, 'entreprise');

--  des types de mobilité
INSERT INTO  serse.typeMobilite (typeMobilite_id, typeMobilite_libelle) VALUES (1, 'CME');
INSERT INTO  serse.typeMobilite (typeMobilite_id, typeMobilite_libelle) VALUES (2, 'Année');
INSERT INTO  serse.typeMobilite (typeMobilite_id, typeMobilite_libelle) VALUES (3, 'Semestre');
INSERT INTO  serse.typeMobilite (typeMobilite_id, typeMobilite_libelle) VALUES (4, 'STING');
INSERT INTO  serse.typeMobilite (typeMobilite_id, typeMobilite_libelle) VALUES (5, 'Césure');
INSERT INTO  serse.typeMobilite (typeMobilite_id, typeMobilite_libelle) VALUES (6, 'Double diplôme');
INSERT INTO  serse.typeMobilite (typeMobilite_id, typeMobilite_libelle) VALUES (7, 'TFE');

--  des domaines d'activité
INSERT INTO  serse.domaineActivite (domaineActivite_id, domaineActivite_libelle) VALUES (1, 'Informatique');
INSERT INTO  serse.domaineActivite (domaineActivite_id, domaineActivite_libelle) VALUES (2, 'Mécanique');
INSERT INTO  serse.domaineActivite (domaineActivite_id, domaineActivite_libelle) VALUES (3, 'Aéronautique');

--  des continents
INSERT INTO  serse.continent (continent_id, continent_nom) VALUES (1, 'Europe');
INSERT INTO  serse.continent (continent_id, continent_nom) VALUES (2, 'Amérique');
INSERT INTO  serse.continent (continent_id, continent_nom) VALUES (3, 'Asie');
INSERT INTO  serse.continent (continent_id, continent_nom) VALUES (4, 'Afrique');
INSERT INTO  serse.continent (continent_id, continent_nom) VALUES (5, 'Océanie');

--  des pays
-- Europe
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (1, 'Allemagne', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (2, 'Autriche', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (3, 'Belgique', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (4, 'Biélorussie', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (5, 'Danemark', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (6, 'Espagne', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (7, 'Finlande', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (8, 'France', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (9, 'Grèce', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (10, 'Hongrie', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (11, 'Italie', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (12, 'Norvège', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (13, 'Pays-bas', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (14, 'Pologne', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (15, 'Portugal', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (16, 'République Tchèque', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (17, 'Royaume-Uni', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (18, 'Russie', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (19, 'Slovaquie', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (20, 'Solvénie', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (21, 'Suède', 1);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (22, 'Suisse', 1);
-- Amérique
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (23, 'Brésil', 2);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (24, 'Canada', 2);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (25, 'Chili', 2);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (26, 'Etats-Unis', 2);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (27, 'Mexique', 2);
-- Asie
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (28, 'Chine', 3);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (29, 'Corée', 3);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (30, 'Indonésie', 3);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (32, 'Inde', 3);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (33, 'Japon', 3);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (34, 'Liban', 3);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (35, 'Malaysie', 3);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (36, 'Taïwan', 3);
-- Afrique
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (37, 'Afrique du Sud', 4);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (38, 'Algérie', 4);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (39, 'Egypte', 4);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (40, 'Maroc', 4);
-- Océanie
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (41, 'Australie', 5);
INSERT INTO  serse.pays (pays_id, pays_nom, continent_id) VALUES (42, 'Nouvelle-Zélande', 5);

--  des villes
INSERT INTO  serse.ville (ville_id, ville_nom, pays_id) VALUES (1, 'Paris', 8);
INSERT INTO  serse.ville (ville_id, ville_nom, pays_id) VALUES (2, 'New York', 26);
INSERT INTO  serse.ville (ville_id, ville_nom, pays_id) VALUES (3, 'Los Angeles', 26);
INSERT INTO  serse.ville (ville_id, ville_nom, pays_id) VALUES (4, 'Washington', 26);
INSERT INTO  serse.ville (ville_id, ville_nom, pays_id) VALUES (5, 'Londres', 17);
INSERT INTO  serse.ville (ville_id, ville_nom, pays_id) VALUES (6, 'São Paulo', 23);
INSERT INTO  serse.ville (ville_id, ville_nom, pays_id) VALUES (7, 'Tokyo', 33);
INSERT INTO  serse.ville (ville_id, ville_nom, pays_id) VALUES (8, 'Madrid', 6);
INSERT INTO  serse.ville (ville_id, ville_nom, pays_id) VALUES (9, 'Pékin', 28);

--  des universités
INSERT INTO  serse.universite (universite_id, universite_nom, ville_id) VALUES (1, 'Columbia', 2);
INSERT INTO  serse.universite (universite_id, universite_nom, ville_id) VALUES (2, 'University of NYC', 2);
INSERT INTO  serse.universite (universite_id, universite_nom, ville_id) VALUES (3, 'London School of Economics', 5);
INSERT INTO  serse.universite (universite_id, universite_nom, ville_id) VALUES (4, 'Imperial College', 5);
INSERT INTO  serse.universite (universite_id, universite_nom, ville_id) VALUES (5, 'University College London', 5);
INSERT INTO  serse.universite (universite_id, universite_nom, ville_id) VALUES (6, 'Kings college', 5);
INSERT INTO  serse.universite (universite_id, universite_nom, ville_id) VALUES (7, 'Escola Politécnica da Universidad de São Paulo', 6);
INSERT INTO  serse.universite (universite_id, universite_nom, ville_id) VALUES (8, 'Keio University', 7);

--  des entreprises
INSERT INTO  serse.entreprise (entreprise_id, entreprise_nom) VALUES (1,'Google');
INSERT INTO  serse.entreprise (entreprise_id, entreprise_nom) VALUES (2,'Microsoft');
INSERT INTO  serse.entreprise (entreprise_id, entreprise_nom) VALUES (3,'Airbus');

--  des états des rapports
INSERT INTO  serse.etat (etat_id, etat_libelle) VALUES (1, 'soumis');
INSERT INTO  serse.etat (etat_id, etat_libelle) VALUES (2, 'invalidé');
INSERT INTO  serse.etat (etat_id, etat_libelle) VALUES (3, 'validé');
INSERT INTO  serse.etat (etat_id, etat_libelle) VALUES (4, 'en ligne');
INSERT INTO  serse.etat (etat_id, etat_libelle) VALUES (5, 'hors ligne');

--  des langues
INSERT INTO  serse.langue (langue_id, langue_nom) VALUES (1, 'Anglais');
INSERT INTO  serse.langue (langue_id, langue_nom) VALUES (2, 'Français');
INSERT INTO  serse.langue (langue_id, langue_nom) VALUES (3, 'Espagnol');
INSERT INTO  serse.langue (langue_id, langue_nom) VALUES (4, 'Allemand');
INSERT INTO  serse.langue (langue_id, langue_nom) VALUES (5, 'Italien');
INSERT INTO  serse.langue (langue_id, langue_nom) VALUES (6, 'Portugais');
INSERT INTO  serse.langue (langue_id, langue_nom) VALUES (7, 'Chinois');
INSERT INTO  serse.langue (langue_id, langue_nom) VALUES (8, 'Japonais');

--  des utilisateurs
INSERT INTO  serse.utilisateur (utilisateur_id, utilisateur_nom, utilisateur_prenom, utilisateur_sexe, utilisateur_email) 
VALUES (1, 'Vermillard', 'Sabine', 'F', 'Sabine.Vermillard@EC-Nantes.fr');
INSERT INTO  serse.utilisateur (utilisateur_id, utilisateur_nom, utilisateur_prenom, utilisateur_sexe, utilisateur_email) 
VALUES (2, 'Bennis', 'Fouad', 'M', 'Fouad.Bennis@ec-nantes.fr');
INSERT INTO  serse.utilisateur (utilisateur_id, utilisateur_nom, utilisateur_prenom, utilisateur_sexe, utilisateur_email) 
VALUES (3, 'Pouchoulin', 'Audrey', 'F', 'Audrey.Pouchoulin@eleves.ec-nantes.fr');
INSERT INTO  serse.utilisateur (utilisateur_id, utilisateur_nom, utilisateur_prenom, utilisateur_sexe, utilisateur_email) 
VALUES (4, 'Doucouré', 'Clara', 'F', 'Clara.Doucoure@eleves.ec-nantes.fr');

--  des membres de la DRI
INSERT INTO  serse.dri (dri_id, dri_notification_assignation, dri_notification_soumission, utilisateur_id) VALUES (1, true, true, 1);
INSERT INTO  serse.dri (dri_id, dri_notification_assignation, dri_notification_soumission, utilisateur_id) VALUES (2, true, true, 2);

--  des administrateurs
INSERT INTO  serse.administrateur (administrateur_id, administrateur_notification, utilisateur_id) VALUES (1, true, 1);

-- (A MODIFIER)
--INSERT INTO  serse.dri_etat (etat_id, dri_id)

--  des lieux de séjour
INSERT INTO  serse.lieuSejour (lieuSejour_id, ville_id, lieuSejour_adresse, lieuSejour_codePostal, lieuSejour_GPSlatitude, lieuSejour_GPSlongitude)
VALUES (1, 6, 'Av. Prof. Almeida Prado, nº1280 - Butantã', '05508-070', 0, 0);
INSERT INTO  serse.lieuSejour (lieuSejour_id, ville_id, lieuSejour_adresse, lieuSejour_codePostal, lieuSejour_GPSlatitude, lieuSejour_GPSlongitude)
VALUES (2, 7, 'Adresse en japonais ...', 'code post', 0, 0);
INSERT INTO  serse.lieuSejour (lieuSejour_id, ville_id, lieuSejour_adresse, lieuSejour_codePostal, lieuSejour_GPSlatitude, lieuSejour_GPSlongitude)
VALUES (3, 8, 'Calle del stage', '00000', 0, 0);
INSERT INTO  serse.lieuSejour (lieuSejour_id, ville_id, lieuSejour_adresse, lieuSejour_codePostal, lieuSejour_GPSlatitude, lieuSejour_GPSlongitude)
VALUES (4, 9, 'adresse en joli chinois', 'xxxxx', 0, 0);
INSERT INTO  serse.lieuSejour (lieuSejour_id, ville_id, lieuSejour_adresse, lieuSejour_codePostal, lieuSejour_GPSlatitude, lieuSejour_GPSlongitude)
VALUES (5, 5, '10 downing street', '11111', 0, 0);


--  des rapports 
-- semestre académique université
INSERT INTO  serse.rapport (rapport_id, rapport_nom, rapport_datedebut, rapport_datefin, rapport_numeroversion, rapport_taillefichier, 
typemobilite_id, typesejour_id, typeexperience_id, utilisateur_id, dri_id, universite_id, entreprise_id, domaineactivite_id, lieuSejour_id) 
VALUES (1, 'Brésil_Semestre_Informatique_2012_apouchel', DATE '10/02/2012', DATE '10/08/2012', 1, '10Go',
3, 1, 1, 3, 1, 7, null, 1, 1);
-- semestre professionnel entreprise
INSERT INTO  serse.rapport (rapport_id, rapport_nom, rapport_datedebut, rapport_datefin, rapport_numeroversion, rapport_taillefichier, 
typemobilite_id, typesejour_id, typeexperience_id, utilisateur_id, dri_id, universite_id, entreprise_id, domaineactivite_id, lieuSejour_id) 
VALUES (2, 'Japon_Semestre_Mécanique_2012_cdoucour', DATE '10/02/2012', DATE '10/08/2012', 1, '10Go',
3, 2, 2, 4, 1, null, 3, 2, 2);

-- cesure académique université
INSERT INTO  serse.rapport (rapport_id, rapport_nom, rapport_datedebut, rapport_datefin, rapport_numeroversion, rapport_taillefichier, 
typemobilite_id, typesejour_id, typeexperience_id, utilisateur_id, dri_id, universite_id, entreprise_id, domaineactivite_id, lieuSejour_id) 
VALUES (3, 'Brésil_Césure_Informatique_2014_apouchel', DATE '01/09/2014', DATE '01/09/2015', 1, '10Go',
5, 1, 1, 3, 1, 7, null, 1, 1);
-- cesure professionnel université
INSERT INTO  serse.rapport (rapport_id, rapport_nom, rapport_datedebut, rapport_datefin, rapport_numeroversion, rapport_taillefichier, 
typemobilite_id, typesejour_id, typeexperience_id, utilisateur_id, dri_id, universite_id, entreprise_id, domaineactivite_id, lieuSejour_id) 
VALUES (4, 'Japon_Césure_Mécanique_2014_cdoucour', DATE '01/09/2014', DATE '01/09/2015', 1, '10Go',
5, 1, 2, 4, 1, 8, null, 2, 2);

-- CME professionnel entreprise
INSERT INTO  serse.rapport (rapport_id, rapport_nom, rapport_datedebut, rapport_datefin, rapport_numeroversion, rapport_taillefichier, 
typemobilite_id, typesejour_id, typeexperience_id, utilisateur_id, dri_id, universite_id, entreprise_id, domaineactivite_id, lieuSejour_id) 
VALUES (5, 'Espagne_CME_Informatique_2013_cdoucour', DATE '10/07/2013', DATE '10/08/2013', 1, '1Go',
1, 2, 2, 4, 1, null, 1, 1, 3);
-- STING professionnel entreprise
INSERT INTO  serse.rapport (rapport_id, rapport_nom, rapport_datedebut, rapport_datefin, rapport_numeroversion, rapport_taillefichier, 
typemobilite_id, typesejour_id, typeexperience_id, utilisateur_id, dri_id, universite_id, entreprise_id, domaineactivite_id, lieuSejour_id) 
VALUES (6, 'Chine_STING_Informatique_2013_cdoucour', DATE '10/05/2013', DATE '01/09/2013', 1, '1Go',
4, 2, 2, 4, 1, null, 2, 1, 4);
-- TFE professionnel entreprise
INSERT INTO  serse.rapport (rapport_id, rapport_nom, rapport_datedebut, rapport_datefin, rapport_numeroversion, rapport_taillefichier, 
typemobilite_id, typesejour_id, typeexperience_id, utilisateur_id, dri_id, universite_id, entreprise_id, domaineactivite_id, lieuSejour_id) 
VALUES (7, 'Chine_TFE_Informatique_2013_cdoucour', DATE '10/05/2013', DATE '01/09/2013', 1, '1Go',
7, 2, 2, 4, 1, null, 2, 1, 4);

-- DD académique université
INSERT INTO  serse.rapport (rapport_id, rapport_nom, rapport_datedebut, rapport_datefin, rapport_numeroversion, rapport_taillefichier, 
typemobilite_id, typesejour_id, typeexperience_id, utilisateur_id, dri_id, universite_id, entreprise_id, domaineactivite_id, lieuSejour_id) 
VALUES (8, 'Royaume-Uni_DoubleDiplome_Informatique_2020_apouchel', DATE '01/09/2020', DATE '01/09/2021', 1, '1Go',
6, 1, 1, 3, 1, 3, null, 1, 5);
-- Année académique université
INSERT INTO  serse.rapport (rapport_id, rapport_nom, rapport_datedebut, rapport_datefin, rapport_numeroversion, rapport_taillefichier, 
typemobilite_id, typesejour_id, typeexperience_id, utilisateur_id, dri_id, universite_id, entreprise_id, domaineactivite_id, lieuSejour_id) 
VALUES (9, 'Royaume-Uni_Année_Informatique_2020_cdoucour', DATE '01/09/2020', DATE '01/09/2021', 1, '1Go',
2, 1, 1, 4, 1, 4, null, 1, 5);

--  d'association de langue(s) à un rapport
INSERT INTO  serse.rapport_langue (rapport_id, langue_id) VALUES (1,6);
INSERT INTO  serse.rapport_langue (rapport_id, langue_id) VALUES (2,1);
INSERT INTO  serse.rapport_langue (rapport_id, langue_id) VALUES (3,6);
INSERT INTO  serse.rapport_langue (rapport_id, langue_id) VALUES (4,1);
INSERT INTO  serse.rapport_langue (rapport_id, langue_id) VALUES (5,3);
INSERT INTO  serse.rapport_langue (rapport_id, langue_id) VALUES (6,7);
INSERT INTO  serse.rapport_langue (rapport_id, langue_id) VALUES (7,7);
INSERT INTO  serse.rapport_langue (rapport_id, langue_id) VALUES (8,1);
INSERT INTO  serse.rapport_langue (rapport_id, langue_id) VALUES (9,1);

--  d'association des entreprises à des pays
INSERT INTO  serse.entreprise_pays (entreprise_id, pays_id) VALUES (1,26);
INSERT INTO  serse.entreprise_pays (entreprise_id, pays_id) VALUES (1,17);
INSERT INTO  serse.entreprise_pays (entreprise_id, pays_id) VALUES (2,26);
INSERT INTO  serse.entreprise_pays (entreprise_id, pays_id) VALUES (2,17);

--  des commentaires
-- INSERT INTO  serse.commentaire (commentaire_id, commentaire_dateHeure, commentaire_contenu, fichier_id, dri_id);

--  des sessions
-- INSERT INTO  serse.sessionutilisateur (session_id, session_adresseIP, session_dateHeureDebut, session_dateHeureFin, utilisateur_id)