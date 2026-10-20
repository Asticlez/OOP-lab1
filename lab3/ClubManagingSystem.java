package lab3;

public class ClubManagingSystem {
    private Club[] clubList;

    public ClubManagingSystem(Club[] clubs) {
        clubList = clubs.clone();
    }

    public int determineAllBudget() {
        int total = 0;
        for (Club club : clubList) {
            total += club.determineBudget();
        }
        return total;
    }

    public int getAllMembers() {
        int total = 0;
        for (Club club : clubList) {
            total += club.getNumMember();
        }
        return total;
    }

    public Club getHighestMemberClub() {
        Club highest = null;
        for (Club club : clubList) {
            if (highest == null || club.getNumMember() > highest.getNumMember()) {
                highest = club;
            }
        }
        return highest;
    }
}
