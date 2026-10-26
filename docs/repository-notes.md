# Atelier 3 - Couche Repository

## Choix de l'interface

Les neuf repositories utilisent `JpaRepository<Entite, Long>`. Ce choix fournit :

- le CRUD complet (`save`, `findById`, `deleteById`, etc.) ;
- des collections retournées sous forme de `List` ;
- le tri et la pagination ;
- les opérations propres a JPA comme `flush` et `saveAndFlush`.

`CrudRepository` expose les collections sous forme de `Iterable`, tandis que
`PagingAndSortingRepository` ne fournit pas le CRUD depuis Spring Data 3.
`JpaRepository` reunit les besoins CRUD, liste, tri et pagination dans une seule
interface.

| Entite | Repository | Type de cle |
| --- | --- | --- |
| Agence | `IAgenceRepository` | `Long` |
| Employe | `IEmployeRepository` | `Long` |
| Vehicule | `IVehiculeRepository` | `Long` |
| Equipement | `IEquipementRepository` | `Long` |
| Client | `IClientRepository` | `Long` |
| Reservation | `IReservationRepository` | `Long` |
| Contrat | `IContratRepository` | `Long` |
| Paiement | `IPaiementRepository` | `Long` |
| Maintenance | `IMaintenanceRepository` | `Long` |

## Rappels CRUD

- `save` effectue un `INSERT` pour une nouvelle entite et un `UPDATE` pour une
  entite existante ; l'objet retourne doit etre utilise.
- `findById` retourne un `Optional`, qui doit etre traite avant l'acces a
  l'entite.
- `deleteById` supprime par identifiant. Les suppressions via le contexte de
  persistance respectent les cascades et `orphanRemoval`.
- Les suppressions en lot contournent le contexte de persistance : elles ne
  doivent pas etre utilisees pour supprimer un `Contrat` lorsque ses
  `Paiement` doivent etre geres par la cascade.

## Demonstration CRUD

La classe `CrudDemoRunner` montre `save`, `findById`, la mise a jour avec
`save`, puis `deleteById` sur un `Contrat`. Elle est desactivee par defaut afin
de ne pas modifier la base lors d'un demarrage normal ou d'un test.

Pour l'activer ponctuellement :

```text
mvnw.cmd spring-boot:run -Dspring-boot.run.arguments=--app.crud-demo.enabled=true
```

Le runner cree puis supprime son contrat de demonstration. Les logs SQL et les
messages `save`, `findById` et `deleteById` permettent d'observer les operations.

## Anomalies relevees et corrections

| Anomalie | Regle / risque | Correction |
| --- | --- | --- |
| Import `org.hibernate.annotations.Fetch` inutilise dans `Contrat` | Import inutilise, bruit de compilation et de relecture | Import supprime |
| Interfaces repository absentes | Couche de persistance incomplete | Creation des neuf interfaces `I...Repository` |
| Noms de repositories non uniformes dans le modele initial | La convention `I...Repository` facilite la decouverte et l'injection | Convention appliquee aux neuf interfaces |

L'analyse SonarQube for IDE doit etre lancee depuis IntelliJ IDEA sur les
packages `Domain` et `repository`. Les corrections de code directement liees a
cet atelier sont documentees ci-dessus ; l'analyse IDE elle-meme ne peut pas
etre executee par Maven.
