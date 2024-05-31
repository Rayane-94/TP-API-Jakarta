## Rayane Besrour et Adam El Ounissi
## Requete CRUD:

## Utilisateur

### ajouter un nouvelle utilisateur (POST) = `http://localhost:8080/users`
body { 
    "nom": "mon nom",
    "prenom" : "mon prenom",
    "email": "mon email",
    "mdp": "mon mdp"
}
### recuperer liste de tout les utilisateur (GET) = `http://localhost:8080/users`
### recuperer un utilisateur specifique (GET) = `http://localhost:8080/users/{uuid}`
### modifier un utilisateur (PUT) = `http://localhost:8080/users/{uuid}`
### supprimer un utilisateur specifique (DELETE) = `http://localhost:8080/users/{uuid}`

## Billet

### ajouter un nouveau Billet (POST) = `http://localhost:8080/billets` 
body {
    "prix": 120,
    "nbBillet" : 1,
    "epreuveUuid" : "{uuid de l'epreuve}",
    "utilisateurUuid": "{uuid de l'utilisateur}"
}
### recuperer liste de tout les billets (GET) = `http://localhost:8080/billets`
### recuperer un billets specifique (GET) = `http://localhost:8080/billets/{uuid}`  
### modifier un billets (PUT) = `http://localhost:8080/billets/{uuid}`    
### supprimer un billet specifique (DELETE) = `http://localhost:8080/billets/{uuid}`  

## Epreuve

### ajouter un nouvelle epreuve (POST) = `http://localhost:8080/epreuves`
body {
    "nomEpreuve": "epreuve test",
    "date": "2024-06-28",
    "adresse": "Paris"
}
### recuperer liste de tout les epreuve (GET) = `http://localhost:8080/epreuves`
### recuperer une epreuve specifique (GET) = `http://localhost:8080/epreuves/{uuid}`
### modifier une epreuve (PUT) = `http://localhost:8080/epreuves/{uuid}`
### supprimer une epreuve specifique (DELETE) = `http://localhost:8080/epreuves/{uuid}`

## Organisateur

### ajouter un nouvelle organisateur (POST) = `http://localhost:8080/organisateurs` 
body {   
    "nom": "nomOrganisateur",
    "prenom":"prenomOrganisateur",
    "lieu": "Paris"  
}
### recuperer liste de tout les organisateur (GET) = `http://localhost:8080/organisateurs`
### recuperer un organisateur specifique (GET) = `http://localhost:8080/organisateurs/{uuid}`
### modifier un organisateur (PUT) = `http://localhost:8080/organisateurs/{uuid}`
### supprimer un organisateur specifique (DELETE) = `http://localhost:8080/organisateurs/{uuid}`
