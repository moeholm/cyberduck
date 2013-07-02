package ch.cyberduck.core.transfer.download;

/*
 * Copyright (c) 2002-2013 David Kocher. All rights reserved.
 * http://cyberduck.ch/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to feedback@cyberduck.ch
 */

import ch.cyberduck.core.Path;
import ch.cyberduck.core.Session;
import ch.cyberduck.core.threading.BackgroundException;
import ch.cyberduck.core.transfer.TransferStatus;
import ch.cyberduck.core.transfer.symlink.SymlinkResolver;

/**
 * @version $Id$
 */
public class ResumeFilter extends AbstractDownloadFilter {

    public ResumeFilter(final SymlinkResolver symlinkResolver) {
        super(symlinkResolver);
    }

    @Override
    public boolean accept(final Session session, final Path file) throws BackgroundException {
        if(file.attributes().isDirectory()) {
            if(file.getLocal().exists()) {
                return false;
            }
        }
        if(file.getLocal().attributes().getSize() >= file.attributes().getSize()) {
            // No need to resume completed transfers
            return false;
        }
        return super.accept(session, file);
    }

    @Override
    public TransferStatus prepare(final Session session, final Path file) throws BackgroundException {
        final TransferStatus status = super.prepare(session, file);
        if(file.getSession().isDownloadResumable()) {
            if(file.attributes().isFile()) {
                if(file.getLocal().exists()) {
                    if(file.attributes().getSize() > 0) {
                        status.setResume(true);
                        status.setCurrent(file.getLocal().attributes().getSize());
                    }
                }
            }
        }
        return status;
    }
}