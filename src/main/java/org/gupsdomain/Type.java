package org.gupsdomain;

public enum Type {
    IQ, DX, HT, ST, Per, Will, Skill {
        @Override
        public void registerIn(Provide provide, String skillName, String defaultName) {
            provide.registerDefaultFor(skillName, defaultName);
        }
    };

    public void registerIn(Provide provide, String skillName, String _) {
        provide.registerDefaultFor(skillName, this.name());
    }
}
