package pglp.orgdir;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class OrganizationElement implements Iterable<OrganizationElement> {
    @Override
    public Iterator<OrganizationElement> iterator() {
        List<OrganizationElement> list = new ArrayList<>();
        list.add(this);
        addSubElements(list);
        return list.iterator();
    }

    protected abstract void addSubElements(List<OrganizationElement> list);

    public abstract String getDescription();
}
