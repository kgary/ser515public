package ser515.inheritance;

class Root {
    public void print() { System.out.println(Polymorph1NC.getCount() + ":\tI'm a Root object: " + toString()); }
}
class RootSub extends Root {
    public void print() { System.out.println(Polymorph1NC.getCount() + ":\tI'm a RootSub object: " + toString()); }
    public void printExt() { System.out.println(Polymorph1NC.getCount() + ":\tRootSub object extension method: " + toString()); }
}
class RootSubSibling extends Root {
    public void print() { System.out.println(Polymorph1NC.getCount() + ":\tI'm a RootSubSibling object: " + toString()); }
}
class RootDesc extends RootSub {
    public void print() { System.out.println(Polymorph1NC.getCount() + ":\tI'm a RootDesc object: " + toString()); }
}
